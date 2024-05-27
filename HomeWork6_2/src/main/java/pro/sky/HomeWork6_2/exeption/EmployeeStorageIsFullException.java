package pro.sky.HomeWork6_2.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(){
        super("Хранилеще заполнено!");
    }
}