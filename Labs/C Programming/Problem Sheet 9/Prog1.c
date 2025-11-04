#include<stdio.h>
#include<string.h>
#include<stdbool.h>

struct Phone {
    char firstName[10];
    char lastName[10];
    char phoneNumber[10];
};

bool compare(struct Phone p1, struct Phone p2){

    if(strcmp(p1.phoneNumber,p2.phoneNumber)==0)
        return true;
    
    return false;
} 

int main(){
    struct Phone person1, person2;

    printf("Enter first name for p1: ");
    scanf("%10s",person1.firstName);
    
    printf("Enter last name for p1: ");
    scanf("%10s",person1.lastName);

    printf("Enter phone number for p1: ");
    scanf("%9s", person1.phoneNumber);

    printf("Enter first name for p2: ");
    scanf("%9s", person2.firstName);

     printf("Enter last name for p2: ");
    scanf("%9s", person2.lastName);

    printf("Enter phone number for p2: ");
    scanf("%9s", person2.phoneNumber);

    if(compare(person1,person2))
    printf("The phone no matched \n");
    else
        printf("The phone no do not match");
    return 0;
}