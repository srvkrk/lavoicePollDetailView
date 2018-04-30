package com.lavoice.dao;

import com.lavoice.bean.PollDetailResponse;

public interface PollDetailDao {
  PollDetailResponse find(String pollId);
}
