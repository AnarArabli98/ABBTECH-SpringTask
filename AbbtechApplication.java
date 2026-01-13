package com.anararabli.abbtech;

import com.anararabli.abbtech.config.ItemDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AbbtechApplication {


	static void main(String[] args) {
		var app = SpringApplication.run(AbbtechApplication.class, args);
//		ItemDao dao = app.getBean(ItemDao.class);
//		System.out.println(dao.hashCode());

	}
}