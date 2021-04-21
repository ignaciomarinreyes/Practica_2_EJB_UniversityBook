/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.Post;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 *
 * @author ignacio
 */
@Singleton
public class PostBeanLocal implements PostBeanLocalLocal {
    
    private ArrayList<PostUserBean> postUserBeans;

    @PostConstruct
    public void init() {
        postUserBeans = new ArrayList<PostUserBean>();
    }

    @Override
    public void addPostUserBean(PostUserBean postUserBean) {
        postUserBeans.add(postUserBean);
    }
    
    
}
