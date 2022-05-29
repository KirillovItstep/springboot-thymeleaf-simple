package org.itstep.i18n;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    public class ControllerI18n {

        @GetMapping("/international")
        public String getInternationalPage() {
            return "international";
        }

    }
