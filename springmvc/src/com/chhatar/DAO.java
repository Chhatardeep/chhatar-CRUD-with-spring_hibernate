package com.chhatar;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;

public abstract class DAO {

public abstract void addData(Alien a);
public abstract void updateData(Alien a,HttpServletRequest request, HttpServletResponse response);
public abstract void deleteData(@RequestParam("y1") int i,Alien a);
public abstract Object findData(Alien a);
public abstract List<Alien> getAllData(Alien a);
}
