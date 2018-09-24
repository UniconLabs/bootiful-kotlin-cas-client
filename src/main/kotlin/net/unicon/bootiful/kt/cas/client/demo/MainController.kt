package net.unicon.bootiful.kt.cas.client.demo

import net.unicon.cas.client.configuration.CasClientConfigurerAdapter
import net.unicon.cas.client.configuration.EnableCasClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import javax.servlet.http.HttpServletRequest


/**
 * @author Dmitriy Kopylenko
 */
@Controller
@EnableCasClient
class MainController : CasClientConfigurerAdapter() {

    @Value("\${casLogoutUrl}")
    val casLogoutUrl: String? = null

    @GetMapping("/")
    fun index() = "index"

    @GetMapping("/protected")
    fun protected(request: HttpServletRequest, model: Model): String {
        model.addAttribute("principal", request.userPrincipal)
        return "protected"
    }

    override fun configureValidationFilter(validationFilter: FilterRegistrationBean<*>?) {
        validationFilter!!.initParameters["millisBetweenCleanUps"] = "120000"
    }

    /**
     * Example of customizing the filter config for any 'exotic' properties that are not exposed via properties file
     */
    /*
    override fun configureAuthenticationFilter(authenticationFilter: FilterRegistrationBean<*>?) {
        authenticationFilter!!.initParameters["artifactParameterName"] = "tckt"
        authenticationFilter.initParameters["serviceParameterName"] = "customServiceParam"
    }*/
}