package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "server-xqt")
public interface MeberService extends MeberServiceApi{



}
