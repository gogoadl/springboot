package com.littlesight.springboot.domain.posts;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class PostsReporitory implements JpaRepository<Posts, Long> {
    @Override
    public List<Posts> findAll() {
        return null;
    }

    @Override
    public List<Posts> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Posts> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Posts> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Posts entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Posts> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Posts> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Posts> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Posts> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Posts> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Posts> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Posts getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Posts> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Posts> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Posts> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Posts> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Posts> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Posts> boolean exists(Example<S> example) {
        return false;
    }
    // Posts 클래스로 데이터베이스 접근 가능하게할 JPARepository

}
