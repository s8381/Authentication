package springboot.authentication.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Base {
    private String createBy;
    private String createTime;
    private String updateBy;
    private String updateTime;
}
