CREATE database jobportal_db;
use jobportal_db;

CREATE TABLE User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(55) UNIQUE NOT NULL,
    password VARCHAR(25) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    role VARCHAR(25) UNIQUE NOT NULL,
    phone INT,
    register_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(25) DEFAULT 'Active'
);

CREATE TABLE Company (
    company_id INT AUTO_INCREMENT PRIMARY KEY,
    employer_id INT,
    company_name VARCHAR(255) NOT NULL,
    company_address TEXT NOT NULL,
    company_website VARCHAR(255),
    company_email VARCHAR(255),
    added_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    company_size varchar(100),
    founded_year varchar(123),
    industry varchar(214),
    FOREIGN KEY (employer_id) REFERENCES User(user_id)
);

CREATE TABLE Candidate (
    candidate_id INT AUTO_INCREMENT PRIMARY KEY,
    job_seeker_id INT,
    resume longblob,
    cover TEXT,
    FOREIGN KEY (job_seeker_id) REFERENCES User(user_id)
);

CREATE TABLE Job (
    job_id INT AUTO_INCREMENT PRIMARY KEY,
    employer_id INT,
    job_title VARCHAR(255) NOT NULL,
    job_description TEXT NOT NULL,
    location VARCHAR(255) NOT NULL,
    salary DECIMAL(10,2),
    job_type VARCHAR(255) NOT NULL,
    posted_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(255) DEFAULT 'Open',
    experience varchar(233),
    requirements varchar(233),
    responsibilities varchar(233),
    benefits varchar(233),
    openings varchar(233),
    FOREIGN KEY (employer_id) REFERENCES User(user_id)
);

CREATE TABLE Application (
    application_id INT AUTO_INCREMENT PRIMARY KEY,
    candidate_id INT,
    job_id INT,
    user_id INT,
    cover_letter TEXT,
    applied_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status  VARCHAR(255),
    FOREIGN KEY (candidate_id) REFERENCES Candidate(candidate_id),
    FOREIGN KEY (job_id) REFERENCES Job(job_id),
    FOREIGN KEY (user_id) REFERENCES User(user_id)    
);



