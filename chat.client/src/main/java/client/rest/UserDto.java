package client.rest;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "user")
@Data
public class UserDto implements Serializable {
    private Long id;
    private String name;
}
