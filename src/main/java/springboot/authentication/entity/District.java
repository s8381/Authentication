package springboot.authentication.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class District extends Base{
    private String id;
    private String cId;
    private String name;
}
