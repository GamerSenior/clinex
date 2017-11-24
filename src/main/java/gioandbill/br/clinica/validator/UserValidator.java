package gioandbill.br.clinica.validator;

import gioandbill.br.clinica.models.Login;
import gioandbill.br.clinica.services.UserService;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import sun.rmi.runtime.Log;

@Component
public class UserValidator implements Validator {

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Login.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Login login = (Login) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty");
        if(login.getLogin().length() < 6 || login.getLogin().length() > 32){
            errors.rejectValue("login", "Size.userForm.login");
        }
        if(userService.findByUsername(login.getLogin()) != null){
            errors.rejectValue("login", "Duplicate.userForm.login");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if(login.getPassword().length() < 7 || login.getPassword().length() > 32){
            errors.rejectValue("password", "Size.userForm.password");
        }


    }
}
