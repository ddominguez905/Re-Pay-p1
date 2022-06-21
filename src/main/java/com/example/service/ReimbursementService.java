package com.example.service;

import com.example.entity.re_Status;

public interface ReimbursementService {
    void approve (re_Status status);
    void deny (re_Status status);
}
