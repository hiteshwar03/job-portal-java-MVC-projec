<form action="register" method="POST">
    <label for="username">Username:</label>
    <input type="text" name="username" required><br>

    <label for="password">Password:</label>
    <input type="password" name="password" required><br>

    <label for="email">Email:</label>
    <input type="email" name="email" required><br>

    <label for="email">Phone:</label>
    <input type="number"  name="phone" required><br>

    <label for="role">Role:</label>
    <select name="role" required>
        <option value="Employer">Employer</option>
        <option value="JobSeeker">Job Seeker</option>
    </select><br>

    <input type="submit" value="Register">
</form>
