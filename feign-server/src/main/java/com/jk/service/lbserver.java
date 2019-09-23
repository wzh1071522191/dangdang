package com.jk.service;

import com.jk.model.LunBo;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FeignClient(value="mqc-client")
public interface lbserver extends LunBoService{



}
