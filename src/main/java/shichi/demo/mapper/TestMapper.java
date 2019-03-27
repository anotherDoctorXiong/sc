package shichi.demo.mapper;

import org.springframework.stereotype.Component;
import shichi.demo.model.autoModel.Admin;


@Component
public class TestMapper {
    public Admin findById(String id){
        if(id.equals("123")){
            Admin user=new Admin();
            user.setAdminId("123");
            user.setPassword("$2a$10$4RCIdXlBw8YOgQBWhwZaWOJneGhvgN/5Tj.Z2NJwvi2BYvYnJJwju");
            user.setRole("admin");
            return user;
        }else {
            Admin user=new Admin();
            user.setAdminId("1234");
            user.setPassword("$2a$10$4RCIdXlBw8YOgQBWhwZaWOJneGhvgN/5Tj.Z2NJwvi2BYvYnJJwju");
            user.setRole("user");
            return user;
        }

    }
}
