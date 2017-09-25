package dao;

import java.util.List;

import domain.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ConstantinAgapi on 25/09/2017.
 */
@Repository
public class UserRepository implements JpaRepository<User, Long> {
    public User findByUsername(String username){
        return null;
    }

    @Override
    public <S extends User> S save(final S s) {
        return null;
    }

    @Override
    public User findOne(final Long aLong) {
        return null;
    }

    @Override
    public boolean exists(final Long aLong) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAll(final Sort sort) {
        return null;
    }

    @Override
    public Page<User> findAll(final Pageable pageable) {
        return null;
    }

    @Override
    public List<User> findAll(final Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(final Long aLong) {

    }

    @Override
    public void delete(final User user) {

    }

    @Override
    public void delete(final Iterable<? extends User> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public void deleteInBatch(final Iterable<User> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public User getOne(final Long aLong) {
        return null;
    }

    @Override
    public <S extends User> List<S> findAll(final Example<S> example, final Sort sort) {
        return null;
    }

    @Override
    public <S extends User> List<S> findAll(final Example<S> example) {
        return null;
    }

    @Override
    public <S extends User> S saveAndFlush(final S s) {
        return null;
    }

    @Override
    public <S extends User> List<S> save(final Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends User> S findOne(final Example<S> example) {
        return null;
    }

    @Override
    public <S extends User> Page<S> findAll(final Example<S> example, final Pageable pageable) {
        return null;
    }

    @Override
    public <S extends User> long count(final Example<S> example) {
        return 0;
    }

    @Override
    public <S extends User> boolean exists(final Example<S> example) {
        return false;
    }
}
