package com.sklay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class ChatController
{
    @RequestMapping("index/")
   public String index(){
       
       return "chat.chat" ;
   }
}
