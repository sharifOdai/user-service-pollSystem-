package com.UserService.pollFiegnClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "pollService",
        url = "${pollService.url}"
)


public interface PollService {

    @DeleteMapping("/delete-all-user-answers/{userId}")
    void deleteAllUserAnswersByUserId(@PathVariable Long userId);

}
