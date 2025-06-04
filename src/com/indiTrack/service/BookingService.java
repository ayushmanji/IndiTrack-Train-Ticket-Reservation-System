package com.indiTrack.service;

import java.util.List;

import com.indiTrack.beans.HistoryBean;
import com.indiTrack.beans.TrainException;

public interface BookingService {

	public List<HistoryBean> getAllBookingsByCustomerId(String customerEmailId) throws TrainException;

	public HistoryBean createHistory(HistoryBean bookingDetails) throws TrainException;

}
