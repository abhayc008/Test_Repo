package com.pharmacy.dao;

import java.util.List;

import com.pharmacy.pojo.Feedback;

public interface FeedbackDao 
{
   boolean addFeedback(Feedback feedback );
   List<Feedback> showAllFeedback();
}
