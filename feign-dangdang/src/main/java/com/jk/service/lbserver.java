package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value="mqc-client")
public interface lbserver extends LunBoService{



}
