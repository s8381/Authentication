package springboot.authentication.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member extends Base{
    private String maId;
    private String name;
    private String idNumber;
    private String birthday;
    private String phone;
    private String cId;
    private String dId;
    private String address;
}
