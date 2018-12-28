package com.tokeys.im.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.beetl.sql.core.engine.PageQuery;
import org.jxls.common.Context;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.ReaderConfig;
import org.jxls.reader.XLSReadMessage;
import org.jxls.reader.XLSReadStatus;
import org.jxls.reader.XLSReader;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ibeetl.admin.console.web.dto.DictExcelImportData;
import com.ibeetl.admin.console.web.query.UserQuery;
import com.ibeetl.admin.core.annotation.Function;
import com.ibeetl.admin.core.annotation.Query;
import com.ibeetl.admin.core.entity.CoreDict;
import com.ibeetl.admin.core.entity.CoreUser;
import com.ibeetl.admin.core.file.FileItem;
import com.ibeetl.admin.core.file.FileService;
import com.ibeetl.admin.core.web.JsonResult;
import com.ibeetl.admin.core.util.*;
import com.tokeys.im.entity.*;
import com.tokeys.im.service.*;
import com.tokeys.im.web.query.*;

/**
 * 普通会员 接口
 */
@Controller
public class TkMemberController{

    private final Log log = LogFactory.getLog(this.getClass());
    private static final String MODEL = "/im/member";


    @Autowired private TkMemberService memberService;
    
    @Autowired
    FileService fileService;
    /* 页面 */

    @GetMapping(MODEL + "/index.do")
    @Function("im.member.query")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/im/member/index.html") ;
        view.addObject("search", TkMemberQuery.class.getName());
        return view;
    }

    @GetMapping(MODEL + "/edit.do")
    @Function("im.member.edit")
    @ResponseBody
    public ModelAndView edit(Long ids) {
        ModelAndView view = new ModelAndView("/im/member/edit.html");
        TkMember member = memberService.queryById(ids);
        view.addObject("member", member);
        return view;
    }

    @GetMapping(MODEL + "/add.do")
    @Function("im.member.add")
    @ResponseBody
    public ModelAndView add() {
        ModelAndView view = new ModelAndView("/im/member/add.html");
        return view;
    }

    /* ajax json */

    @PostMapping(MODEL + "/list.json")
    @Function("im.member.query")
    @ResponseBody
    public JsonResult<PageQuery> list(TkMemberQuery condtion)
    {
        PageQuery page = condtion.getPageQuery();
        memberService.queryByCondition(page);
        return JsonResult.success(page);
    }

    @PostMapping(MODEL + "/add.json")
    @Function("im.member.add")
    @ResponseBody
    public JsonResult add(@Validated(ValidateConfig.ADD.class)TkMember member)
    {
        memberService.save(member);
        return new JsonResult().success();
    }

    @PostMapping(MODEL + "/update.json")
    @Function("im.member.update")
    @ResponseBody
    public JsonResult<String> update(@Validated(ValidateConfig.UPDATE.class)  TkMember member) {
        boolean success = memberService.update(member);
        if (success) {
            return new JsonResult().success();
        } else {
            return JsonResult.failMessage("保存失败");
        }
    }


   
    @GetMapping(MODEL + "/view.json")
    @Function("im.member.query")
    @ResponseBody
    public JsonResult<TkMember>queryInfo(Long ids) {
        TkMember member = memberService.queryById( ids);
        return  JsonResult.success(member);
    }

    @PostMapping(MODEL + "/delete.json")
    @Function("im.member.delete")
    @ResponseBody
    public JsonResult delete(String ids) {
        if (ids.endsWith(",")) {
            ids = StringUtils.substringBeforeLast(ids, ",");
        }
        List<Long> idList = ConvertUtil.str2longs(ids);
        memberService.batchDelTkMember(idList);
        return new JsonResult().success();
    }
    

}
