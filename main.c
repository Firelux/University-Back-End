#include <stdio.h>
#include <stdlib.h>

void disp_rip(int pos, int num, int *lungh, int n, int *vet, int *pass, int *sol, int n1){

    int i;

    if(n==0){
        if(*pass==0){
            for(i=0;i<n1;i++){
                sol[i]=vet[i];
            }
            *pass=1;
        }
        return;
    }



    for(i=0;i<num;i++){
        if(*pass==0){
            if(n-lungh[i]>=0){
                vet[pos]=lungh[i];
                n=n-lungh[i];
                disp_rip(pos+1, num, lungh, n, vet, pass,sol,n1);
                vet[pos]=-1;
                n=n+lungh[i];
            }


        }
    }


}




void decomponi(char *str, int num, int *lungh){

    int l=0, min=lungh[0],i,n,j, ind,*pass;

    while(str[l]!='\0'){
        l++;
    }

    int *vet, *sol;

    for(i=0;i<num;i++){
        if(lungh[i]<min){
            min=lungh[i];
        }

    }

    n=l/min;

    vet=malloc(n*sizeof(int));
    sol=malloc(n*sizeof(int));
    pass=calloc(1, sizeof(int));

    for(i=0;i<n;i++){
        vet[i]=-1;
        sol[i]=-1;
    }


    disp_rip(0, num, lungh, l, vet, pass, sol,n);

    ind=0;


    if(sol[0]==-1){
        printf("Non vi sono decomposizioni");
    }

    for(i=0;i<n;i++){

        if(sol[i]>0){
            printf("'");
            for(j=ind;j<ind+sol[i] && j<l;j++){
                printf("%c", str[j]);

            }
            printf("' ");
            ind=j;

        }

    }





}

char *charErase (char *str, int *pos){

    int l1=0, l2=0,l;

    while(pos[l2]!=-1){
        l2++;
    }

    while(str[l1]!='\0'){
        l1++;
    }
    l1++;

    l=l1-l2;

    char *s;

    s=malloc(l*sizeof(char));

    int i, j, contr, ind=0;


    for(i=0;i<l1;i++){
        contr=0;
        for(j=0;j<l2;j++){
            if(i==pos[j]){
                contr=1;
            }

        }

        if(contr==0){
            s[ind]=str[i];
            ind++;
        }


    }

    for(i=0;i<ind;i++){

        printf("%c", s[i]);

    }

    printf("\n");

    return s;

}

int main() {

    int num=3, *lungh, *pos;
    char *str;

    lungh=malloc(num*sizeof(int));

    lungh[0]=2;
    lungh[1]=5;
    lungh[2]=7;

    str=malloc(14*sizeof(char));
    str="ThisIsAString";

    pos=malloc(6*sizeof(int));

    pos[0]=7;
    pos[1]=4;
    pos[2]=2;
    pos[3]=0;
    pos[4]=11;
    pos[5]=-1;


    charErase (str, pos);
    decomponi(str, num, lungh);

    return 0;
}
