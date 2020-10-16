##Description

Sometimes we need to restrict the ability to change the instance fields. For example, the phone number can't just be any string; it should follow some rules. As you can see here, phone number format is different for every country, but they all have some elements in common.

So, you should set the field with a phone number to be private and create a getter and setter to this field. The setter should check the value using a regular expression and should set the value to the field only if the value satisfies all the rules below:
<ul>
<li>The phone number should be split into groups using a space or dash. One group is also possible.
<li>Before the first group, there may or may not be a plus symbol.
<li>The first group or the second group can be wrapped in parentheses, but there should be no more than one group which
 is wrapped in parentheses. There may be no groups wrapped in parentheses.
<li>A group can contain numbers, uppercase, and lowercase English letters. A group should be at least 2 symbols in
 length. But the first group may be only one symbol in length.
</ul>
If you are struggling with a regular expression that checks all of these, you might check the phone number with only String methods.
Also, create getters and setters for the name and surname of the person. Also, there should be a method hasNumber() that checks if the user has a number. Initially, set the number to be an empty string.

Create a separate method to check the validity of the phone number. This is standalone logic and potentially can be used in multiple places of a class. But this is also a method for internal use. Therefore, mark the method as private.

This concept of restricting the usage of a class called encapsulation. This is a self-documented solution for how to use a class.

In this stage, you should write a program that keeps all the records in a list. You should be able to add, remove, edit the records, and get the number of records. If the user inputs an incorrect phone number, you should reset it as empty. If the number is empty, you should write the string [no number] instead of it.