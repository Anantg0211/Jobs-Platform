package com.anant.joblisting.repository;
import com.anant.joblisting.model.post;
import java.util.*;
public interface searchrepo
{
    List<post> findByText(String text);
}
