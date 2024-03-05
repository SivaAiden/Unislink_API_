# Unislink_API_
UnisLink Technical Assessment 
Design and create a Web REST API + SQL for managing users:
User Attributes:
First Name – Text
Last Name – Text
Email – Text (valid email)
DOB – Date field
Gender – Radio/ Combo options (Male | Female | Others)
Hobbies – Multi select options (Reading, Writing, Cooking, Dancing, Singing, Playing, Gardening)
Interests - Textarea
Operations:
+ List all existing users with pagination having columns
• Name ( FirstName, LastName)
• Email
• Age (CurrentDate – DOB in Years)
• Gender
• Hobbies ( Comma seperated values of selected)
• Interests (first 30 chars)
+ Add new user
+ Edit existing user
+ Delete existing user
+ Search user 
• By age (two fields with greater than and less than)
• By name (starts with First or Last Name)
• By Hobbies (atleast one from the selected list
