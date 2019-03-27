package com.lcl.serviceplatform.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.lcl.serviceplatform.pojo.Result;
import com.lcl.serviceplatform.pojo.User;
import com.lcl.serviceplatform.service.UserService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private static final int MAX_INACTIVE = 60;
//
//    @PostMapping("/login")
//    public Result login(User user, HttpSession session) {
//        Result r = new Result(MAX_INACTIVE);
//        user = userService.login(user);
//        if(user == null) {
//            r.setSuccess(false);
//            r.setMsg("用户名或密码错误");
//        } else {
//            session.setMaxInactiveInterval(MAX_INACTIVE);
//            session.setAttribute("user", user);
//            r.setData(user);
//        }
//        return r;
//    }
    @PostMapping
    public Result addUser(User user) {
        Result r = new Result(MAX_INACTIVE);
        userService.addUser(user);
        return r;
    }
    @GetMapping
    public Result findAll(User user) {
        Result r = new Result(MAX_INACTIVE);
        r.setData(userService.findAllUser(user));
        return r;
    }
    @GetMapping(path = "/page")
    public Result findAll(User user, Integer pageNum, Integer pageSize) {
        Result r = new Result(MAX_INACTIVE);
//        System.out.println(user);
        if(pageNum == null || pageNum < 1) {
            pageNum = 1;
        }
        if(pageSize == null || pageSize < 1) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<User> page = new PageInfo(userService.findAllUser(user));
//        System.out.println(userService.findAllUser(user));
        r.setData(page);
//        System.out.println("pagehelper complete");
        return r;
    }

    @DeleteMapping
    public Result deleteUser(String id) {
        Result r = new Result(MAX_INACTIVE);
        userService.deleteUser(id);
        return r;
    }

    @PutMapping
    public Result updateUser(User user) {
        Result r = new Result(MAX_INACTIVE);
        userService.updateUser(user);
        return r;
    }

    @GetMapping(path = "/sheet")
    public void downloadSheet(HttpServletResponse response) throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("人员表");
        // 设置列宽
        sheet.setColumnWidth(0, 4000);
        sheet.setColumnWidth(1, 2000);
        sheet.setColumnWidth(2, 2000);
        sheet.setColumnWidth(3, 4000);
        sheet.setColumnWidth(4, 8000);
        sheet.setColumnWidth(5, 5000);
        sheet.setColumnWidth(6, 4000);
        sheet.setColumnWidth(7, 6000);
        sheet.setColumnWidth(8, 6000);

        // 设置表头样式
        HSSFCellStyle cellstyle = (HSSFCellStyle) wb.createCellStyle();
        cellstyle.setAlignment(HorizontalAlignment.CENTER);// 设置居中
        HSSFFont font = wb.createFont();
        font.setBold(true);
        font.setFontName("黑体");
        font.setFontHeightInPoints((short)20);
        cellstyle.setFont(font);
        // 合并单元格
        CellRangeAddress rangeAddress = new CellRangeAddress(0,0,0,8);
        sheet.addMergedRegion(rangeAddress);

        HSSFRow title = sheet.createRow(0);
        HSSFCell cell = title.createCell(0);
        cell.setCellStyle(cellstyle);
        cell.setCellValue("人员表");


        // 创建表头
        HSSFRow head = sheet.createRow(1);
        head.createCell(0).setCellValue("姓名");
        head.createCell(1).setCellValue("年龄");
        head.createCell(2).setCellValue("性别");
        head.createCell(3).setCellValue("民族");
        head.createCell(4).setCellValue("工作单位");
        head.createCell(5).setCellValue("部门");
        head.createCell(6).setCellValue("政治面貌");
        head.createCell(7).setCellValue("电话");
        head.createCell(8).setCellValue("邮箱");
        // 设置表头样式
        HSSFCellStyle headStyle = (HSSFCellStyle) wb.createCellStyle();
        headStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
        headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFFont headFont = wb.createFont();
        headFont.setFontHeightInPoints((short)13);
        headStyle.setFont(headFont);
        for(Cell c : head) {
            c.setCellStyle(headStyle);
        }
        // 添加数据
        List<User> users = userService.findAllUser(null);
        for(int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            HSSFRow row = sheet.createRow(i + 2);
            row.createCell(0).setCellValue(user.getName());
            row.createCell(1).setCellValue(user.getAge());
            row.createCell(2).setCellValue(user.getGender().getName());
            row.createCell(3).setCellValue(user.getNation().getName());
            row.createCell(4).setCellValue(user.getOrg().getName());
            row.createCell(5).setCellValue(user.getDept());
            row.createCell(6).setCellValue(user.getPolitics().getName());
            row.createCell(7).setCellValue(user.getPhone());
            row.createCell(8).setCellValue(user.getEmail());
        }
        // 发送生成的电子表格
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode("组织机构表.xls", "UTF-8"));
        wb.write(response.getOutputStream());
        wb.close();
    }
}
