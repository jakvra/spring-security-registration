package com.baeldung.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        final HttpSession session = request.getSession();

        if (session != null) {
            final Object user = session.getAttribute("user");
            if (user instanceof LoggedUser) {
                log.debug("User {} attempted to access unauthorized URL {}", ((LoggedUser) user).getUsername(), request.getRequestURL());
            }
        }

        response.sendRedirect("/accessDenied");
    }
}
