/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.controller.admin;

import com.plantshop.dto.AdminPlantDTO;
import com.plantshop.entity.Category;
import com.plantshop.entity.Plant;
import com.plantshop.entity.User;
import com.plantshop.service.CategoryService;
import com.plantshop.service.PlantService;
import com.plantshop.service_impl.CategoryServiceImpl;
import com.plantshop.service_impl.PlantServiceImp;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 *
 * @author Trình Vĩnh Phat
 */
@WebServlet(name = "AdminPlantController", urlPatterns = {"/admin-PlantManaging"})
@MultipartConfig
public class AdminPlantController extends HttpServlet {

    private PlantService plantService = new PlantServiceImp();

    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("User");
        if (user != null) {
            String action = req.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "add":
                    ArrayList<Category> categories = categoryService.findAll();
                    req.setAttribute("action", 1);
                    req.setAttribute("listCategory", categories);
                    req.getRequestDispatcher("WEB-INF/views/admin/PlantForm.jsp").forward(req, resp);
                    return;
                case "edit":
                    categories = categoryService.findAll();
                    String id = req.getParameter("id");
                    Plant plant = plantService.findById(Integer.parseInt(id));
                    req.setAttribute("plant", plant);
                    req.setAttribute("action", 2);
                    req.setAttribute("listCategory", categories);
                    req.getRequestDispatcher("WEB-INF/views/admin/PlantForm.jsp").forward(req, resp);
                    return;
                default:
                    ArrayList<Plant> plants = plantService.findAll();
                    ArrayList<AdminPlantDTO> listDTO = new ArrayList<>();

                    for (Plant p : plants) {
                        listDTO.add(new AdminPlantDTO(p, categoryService.findByID(p.getCateID())));
                    }

                    req.setAttribute("listItem", listDTO);
                    req.getRequestDispatcher("WEB-INF/views/admin/PlantManaging.jsp").forward(req, resp);
                    return;
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("User");
        if (user != null) {
            String action = req.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "add":
                    String name = req.getParameter("name");
                    String category = req.getParameter("category");
                    String price = req.getParameter("price");
                    String description = req.getParameter("description");

                    DiskFileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    List<FileItem> items = upload.parseRequest(new ServletRequestContext(req));
                    // Lấy đối tượng Part từ request
                    Part filePart = req.getPart("file");

                    // Lấy tên tệp tin gốc
                    String fileName = getFileName(filePart);

                    // Tạo tên mới cho tệp tin bằng UUID
                    String uuidFileName = UUID.randomUUID().toString() + "." + getFileExtension(fileName);

                    // Lấy đường dẫn tuyệt đối đến thư mục images trên server
                    String uploadPath = "E:\\java language\\IDE netbean\\N project\\WorkShop-op\\web\\resources\\images";


                    // Tạo đối tượng File đại diện cho thư mục images trên server
                    File uploadDir = new File(uploadPath);
                    if (!uploadDir.exists()) {
                        uploadDir.mkdir();
                    }

                    // Lưu tệp tin mới với tên mới vào thư mục images trên server
                    File file = new File(uploadDir, uuidFileName);
                    try (InputStream fileContent = filePart.getInputStream()) {
                        Files.copy(fileContent, file.toPath());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    plantService.save(name, category, price, description, uuidFileName);
                    resp.sendRedirect("admin-PlantManaging");
                    break;
                case "edit":
                    name = req.getParameter("name");
                    category = req.getParameter("category");
                    price = req.getParameter("price");
                    description = req.getParameter("description");
                    String id = req.getParameter("id");

                    factory = new DiskFileItemFactory();
                    upload = new ServletFileUpload(factory);
                    items = upload.parseRequest(new ServletRequestContext(req));
                    // Lấy đối tượng Part từ request
                     filePart = req.getPart("file");

                    // Lấy tên tệp tin gốc
                     fileName = getFileName(filePart);

                    // Tạo tên mới cho tệp tin bằng UUID
                     uuidFileName = UUID.randomUUID().toString() + "." + getFileExtension(fileName);

                    // Lấy đường dẫn tuyệt đối đến thư mục images trên server
                     uploadPath = "E:\\java language\\IDE netbean\\N project\\WorkShop-op\\web\\resources\\images";

                    // Tạo đối tượng File đại diện cho thư mục images trên server
                     uploadDir = new File(uploadPath);
                    if (!uploadDir.exists()) {
                        uploadDir.mkdir();
                    }

                    // Lưu tệp tin mới với tên mới vào thư mục images trên server
                     file = new File(uploadDir, uuidFileName);
                    try (InputStream fileContent = filePart.getInputStream()) {
                        Files.copy(fileContent, file.toPath());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    plantService.update(name, category, price, description, uuidFileName, Integer.parseInt(id));
                    resp.sendRedirect("admin-PlantManaging");
                    break;
            }
        }
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    private String getFileExtension(String fileName) {
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

}
