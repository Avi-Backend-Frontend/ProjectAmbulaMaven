package com.ambula.api.serviceimpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambula.api.entity.User;
import com.ambula.api.repository.UserRepository;
import com.ambula.api.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
    @Transactional
    public void createUserTable() {
        User user1 = new User();
        user1.setName("Admin");
        user1.setLatitude(0.0);
        user1.setLongitude(0.0);
        user1.setExcluded(false);

        User user2 = new User();
        user2.setName("Reader");
        user2.setLatitude(10.0);
        user2.setLongitude(10.0);
        user2.setExcluded(false);

        userRepository.save(user1);
        userRepository.save(user2);
    }

	@Override
	public void updateUser(User user) {
		// Find the existing user by ID
		User existingUser = userRepository.findById(user.getId()).orElse(null);

        // Update the fields of the existing user
        existingUser.setName(user.getName());
        existingUser.setLatitude(user.getLatitude());
        existingUser.setLongitude(user.getLongitude());
        existingUser.setExcluded(user.isExcluded());

        userRepository.save(existingUser);
    }

	@Override
	public List<User> getNearestUsers(int N) {
		List<User> allUsers = userRepository.findAll();

        // Filter out excluded users
        List<User> filteredUsers = allUsers.stream()
                .filter(user -> !user.isExcluded())
                .collect(Collectors.toList());

        // Sort users by distance from (0,0)
        filteredUsers.sort(Comparator.comparingDouble(user -> calculateDistance(user.getLatitude(), user.getLongitude())));

        // Get the nearest N users
        return filteredUsers.stream()
                .limit(N)
                .collect(Collectors.toList());
    }
	// Helper method to calculate distance
    private double calculateDistance(double latitude, double longitude) {
        // Implement your distance calculation logic here
        // This is a simplified example; you would use proper distance calculation algorithms
        return Math.sqrt(latitude * latitude + longitude * longitude);
    }

}
