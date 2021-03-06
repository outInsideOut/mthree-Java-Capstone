/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.models;

import org.springframework.stereotype.Component;

/**
 *
 * @author fionn
 */

/**
 * Parent class of Posts.
 *
 * As posts and static pages are similar in what
 * they contain this DTO is used when the admin wants
 * to switch between making a normal blog post
 * or adding a new static change. The content the data
 * entered by the user regardless, however what is done
 * with this data depends on if the user makes the page static or not.
 */
@Component
public class Content {
    public String title;
    public String post;
    public String imageURL;
    public String staticYN;
    public String postNowYN;

    public String getPostNowYN() {
        return postNowYN;
    }

    public void setPostNowYN(String postNowYN) {
        this.postNowYN = postNowYN;
    }

    public String getStaticYN() {
        return staticYN;
    }

    public void setStaticYN(String staticYN) {
        this.staticYN = staticYN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


    
    
}
