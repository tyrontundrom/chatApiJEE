package model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.Id;


@Setter
public class User {
    private String name;


}
