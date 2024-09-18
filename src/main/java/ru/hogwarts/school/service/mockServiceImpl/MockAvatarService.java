package ru.hogwarts.school.service.mockServiceImpl;


import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.service.AvatarService;


import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@Profile("mock")
public class MockAvatarService implements AvatarService {

    @Override
    public void uploadAvatar(Long studentId, MultipartFile avatarFile) {
        log.info("Upload avatar");
    }

    @Override
    public Avatar findAvatar(Long studentId) {
        log.info("Find avatar");
        return new Avatar();
    }

    @Override
    public List<Avatar> getAllAvatars(int page, int size) {
        log.info("Get all avatars");
        return new ArrayList<>();
    }
}
