package org.example.mvc;

import org.example.mvc.controller.*;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping {
    // key: /users [value] userController
    private Map<HandlerKey, Controller> mappings = new HashMap<>();

    void init() {
        mappings.put(new HandlerKey(RequestMethod.GET,"/"), new HomeController());
        mappings.put(new HandlerKey(RequestMethod.GET,"/users"), new UserListController());
        mappings.put(new HandlerKey(RequestMethod.POST,"/users"), new UserCreateController());
        mappings.put(new HandlerKey(RequestMethod.GET, "/user/forms"), new ForwardController("/user/form.jsp"));
    }
    public Controller findHandler(String urlPath) {
        return mappings.get(urlPath);
    }
}
