
package com.codegym.cms.service;

import com.codegym.cms.model.Post;
import com.codegym.cms.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
}

    @Override
    public void remove(int id) {
        postRepository.deleteById(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public Iterable<Post> findAll(Sort sort) {
        return postRepository.findAll(sort);
    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Page<Post> findAllByName(String name, Pageable pageable){
        return postRepository.findAllByName(name, pageable);
    }

    @Override
    public Iterable<Post> findAllByName(String name, Sort sort) {
        return postRepository.findAllByName(name, sort);
    }

    @Override
    public Page<Post> findAllByCategoryName(String name, Pageable pageable) {
        return postRepository.findAllByCategoryName(name, pageable);
    }

    @Override
    public Iterable<Post> findAllByCategoryName(String name, Sort sort) {
        return postRepository.findAllByCategoryName( name, sort);
    }

//    public Page<Post> convert(Iterable<Post> myPosts, Pageable pageable,Sort sort){
//        List<Post> myPostsList = new ArrayList<>();
//        for(Post post : myPosts){
//            myPostsList.add(post);
//        }
//        Page<Post> myPostsPage = new PageImpl<Post>(myPostsList,
//                PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),Sort.by("name").descending()),
//                myPostsList.size());
//        return myPostsPage;
//    }

}