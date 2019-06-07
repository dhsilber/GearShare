package name.davidsilber.theater.share;

import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class TemplateViewControllers implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("root");
        registry.addViewController("/admin").setViewName("admin");
//        registry.addViewController("/login").setViewName("login");
    }

}
