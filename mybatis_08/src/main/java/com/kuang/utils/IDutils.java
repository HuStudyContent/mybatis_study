package com.kuang.utils;

import org.junit.Test;

import java.util.UUID;

@SuppressWarnings("all")   //抑制所有的警告
public class IDutils {

  //或得了一个随机的id
  public static String getId(){
    return UUID.randomUUID().toString().replaceAll("-","");
  }

  @Test
  public void test(){
    System.out.println(IDutils.getId());
  }
}
