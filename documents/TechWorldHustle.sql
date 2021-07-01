create database techworldhustle;
use techworldhustle;

create table Recruiter
(userId int AUTO_INCREMENT PRIMARY KEY, FirstName varchar(80), LastName varchar(30), Company varchar(30), DOB date, gender varchar(10), Contact varchar(80), Current_location varchar(80), Username varchar(80) UNIQUE, password varchar(80));


create table Candidate
(CandidateId int AUTO_INCREMENT PRIMARY KEY, FirstName varchar(80), LastName varchar(30), Current_Company varchar(30), DOB date, gender varchar(10), Contact varchar(80), Current_location varchar(80),Current_JobTitle varchar(80),CV varchar(80), Username varchar(80) UNIQUE, password varchar(80), keyskills varchar(500));

create table Skill (SkillId int AUTO_INCREMENT PRIMARY KEY, SkillName varchar(80) UNIQUE);

create table Job
(JobId int AUTO_INCREMENT PRIMARY KEY, JobTitle varchar(80), Company varchar(30), StartDate date, status varchar(30),  SalaryOffered double, Location varchar(30), JobDescription varchar(100), RecruiterId int, FOREIGN KEY (RecruiterId) REFERENCES Recruiter(RecruiterId));

create table WalkInDrive
(DriveId int AUTO_INCREMENT PRIMARY KEY, Company varchar(30), DriveDate date, BaseLocation varchar(30), Venue varchar(100), RecruiterId int, FOREIGN KEY (RecruiterId) REFERENCES Recruiter(RecruiterId));


create table Application
( ApplicationId int AUTO_INCREMENT PRIMARY KEY, JobId int , RecruiterId int, CandidateId int , ApplicationDate date, status varchar(20), Remarks varchar (100),
FOREIGN KEY (RecruiterId) REFERENCES Recruiter(RecruiterId),  FOREIGN KEY (CandidateId) REFERENCES Candidate(CandidateId) , FOREIGN KEY (JobId) REFERENCES Job(JobId));

create table CompanyReview
(ReviewId int AUTO_INCREMENT PRIMARY KEY, JobTitle varchar(80), Company varchar(30), EmploymentStatus varchar(10), LastYearOfEmployment int, EmploymentType varchar(20), pros varchar(1000), cons varchar(1000),adviceToManagement varchar(500),additionalComments varchar(500), reviewDate date);

create table IndividualRating
(ReviewId int AUTO_INCREMENT PRIMARY KEY, careerOpportunities double, compensationAndBenefits double, workLifeBalance double, seniorManagement FLOAT, workCulture double, valuesEmployee double, percentRecommendToAFriend double ,businessOutlook double, ceoApproval double,overallRating double,  FOREIGN KEY (ReviewId) REFERENCES CompanyReview(ReviewId) );

create table Company(CompanyId int AUTO_INCREMENT PRIMARY KEY, CompanyName varchar(80));

create table MarketValueSalary
(mvSalaryId int AUTO_INCREMENT PRIMARY KEY, Company varchar(80), JobTitle varchar(30), location varchar(10),EmploymentStatus varchar(10), YearsOfExperience int, EmploymentType varchar(20),  basePay double, cashBonus double, stockBonus double, profitSharing double,salesCommission double, total double);

create table JobAlerts
(alertId int AUTO_INCREMENT PRIMARY KEY, alertName varchar(30), CandidateId int, JobTitle varchar(30), location varchar(50), minSalary double, keySkills varchar(500), FOREIGN KEY (CandidateId) REFERENCES Candidate(CandidateId));


select * from Company;
select * from Job;
select * from Skill;
select * from Application;
select * from Candidate;
select * from Recruiter;
select * from WalkInDrive;
select * from CompanyReview;
select * from IndividualRating;
select * from MarketValueSalary;
select * from JobAlerts;
