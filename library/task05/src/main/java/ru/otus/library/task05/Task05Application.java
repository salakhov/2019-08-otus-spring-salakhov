package ru.otus.library.task05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.library.task05.dao.AuthorDao;
import ru.otus.library.task05.domain.Author;

@SpringBootApplication
public class Task05Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Task05Application.class, args);
//		AuthorDao dao = ctx.getBean(AuthorDao.class);
//		Author autor = dao.getById(1);
	}

}
