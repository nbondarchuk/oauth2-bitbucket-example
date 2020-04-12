package com.nbondarchuk.oauth2.model;

import lombok.Data;

/**
 * @author Nikolay Bondarchuk
 * @since 2020-04-05
 */
@Data
public class User {

    private Long id;

    private String login;

    private String name;
}
