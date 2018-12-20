package com.yrz.oa.core.controller;


import com.yrz.oa.core.po.Clock;
import com.yrz.oa.core.po.ClockTime;
import com.yrz.oa.core.service.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/oaSystem")
public class ClockController {
    @Autowired
    private ClockService clockService;
    /**
     *
     * @param clock
     * @param clockTime
     * @return
     */
    @RequestMapping("/clockIn.action")
    @ResponseBody
    public String clockIn(Clock clock,ClockTime clockTime,String username){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String present = simpleDateFormat.format(date);
        Integer presentDegree = clockService.selectDegree(present,username);
        if (presentDegree == 1){
            return "clocked";
        }else if (presentDegree ==0){
            int row1 = clockService.ClockIn(clock);
            int row2 = clockService.ClockInTime(clockTime);
            if (row1 >0 && row2>0){
                return "success";
            }else {
                return "failure";
            }
        }
       else {
           return "null";
        }
    }

    /**
     *
     * @param username
     * @param date
     * @return
     */
    @RequestMapping("/findTotal.action")
    @ResponseBody
    public Integer findTotal(String username,String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        String date1 = simpleDateFormat.format(date);
        Integer TotalTime = clockService.selectTotalByNameAndDate(username,date1);
        return TotalTime;
    }
}
