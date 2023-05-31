package com.gxy.web.ajax;

import com.alibaba.fastjson.JSON;
import com.gxy.pojo.Brand;
import com.gxy.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ajax/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.调用service查询
        List<Brand> brands = brandService.selectAll();

        // 2.将集合转为json数据（序列化）
        String jsonString = JSON.toJSONString(brands);

        // 3.响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
