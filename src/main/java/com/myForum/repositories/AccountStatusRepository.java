package com.myForum.repositories;

import com.myForum.models.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountStatusRepository extends JpaRepository<AccountStatus, Long> {
}
