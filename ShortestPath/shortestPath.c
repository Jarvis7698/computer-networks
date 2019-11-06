/*
**	Shortest Path in a network using Prim's MST Algorithm.
*/

#include<stdio.h>
#include<stdlib.h>
#define INF 9999

int V,E,G[10][10],C[10][10],M[10][10],key[10],pi[10],vst[10];
int i,j,w,u,v,Q,cost=0,sum,fg=0;

void init() {
	for(i=0;i<10;i++) {
		key[i] = INF;
		vst[i] = 0;
		for(j=0;j<10;j++) {
			G[i][j] = 0;
			C[i][j] = 0;
		}
	}
}

int min() {
	int k,m,mindex=1;
	/*FIND MINIMUM KEY NODE*/
	for(k=0;k<V;k++) {
		if(vst[k]==1) continue;
		else {
			m =key[k];
			mindex=k;
			break;
		}
	}
	for(k=0;k<V;k++) {
		if(m>key[k] && vst[k]==0) {
			mindex=k;
			m=key[k];
		}
	}
	return mindex;
}

/*SHORTEST PATH*/
void findpath(s,d) {
	printf("\nShortest Path: %c",d+65);
	i = 0;
	/*WHILE SOURCE IS DESTINATION*/
	while(d!=s) {
		if(M[d][s]==1) {
			cost += C[d][s];
			for(j=0;j<C[d][s];j++)
				printf("-");
			printf("%c",s+65);
			break;
		}
		if(M[d][i]==1) {
			cost += C[d][i];
			for(j=0;j<C[d][i];j++)
				printf("-");
			printf("%c",i+65);
			d = i;
			i = -1;
		}
		i++;
	}
	printf("\n\nTotal Cost: %d\n",cost);
}

int main() {

	init();
	/*UNDIRECTED GRAPH DETAILS*/
	printf("\n-----SHORTEST PATH-----\n");
	printf("\nRouters: ");
	scanf("%d",&V);
	printf("\nLinks: ");
	scanf("%d",&E);
	
	/*ADJACENCY MATRIX WITH WEIGHT*/
	printf("\nEnter %d Links: \n",E);
	for(i=0;i<E;i++) {
		printf("\nLink%d: ",i+1);
		scanf("%d %d",&u,&v);
		printf("Weight of Link%d: ",i+1);
		scanf("%d",&w);
		C[u-1][v-1] = w;
		C[v-1][u-1] = w;
		G[u-1][v-1] = 1;
		G[v-1][u-1] = 1;
		M[u-1][v-1] = 0;
		M[v-1][u-1] = 0;
	}
	
	/*CHECK FOR ISOLATED NODE*/
	for(i=0;i<V;i++) {
		sum=0;
		for(j=0;j<V;j++) {
			sum+=G[i][j];
		}
		if(sum==0) {
			fg=1;
			printf("\nGraph Error: Isolated Node '%c' Detected!",i+65);
		}
	}	
	if(fg==0) {	
		/*PRIMS ALGORITHM*/
		key[0]= 0;
		pi[0] = 0;Q=V;
		while(Q>0) {
			u = min();
			vst[u] = 1;
			for(v=0;v<V;v++) {
				if(G[u][v]==1) {
					if(vst[v]!=1 && C[u][v]<key[v]) {
						key[v] = C[u][v];
						pi[v] = u;
					}
				}
			}
			Q--;
		}
		
		/*MST GRAPH MATRIX*/
		for(i=0;i<V;i++) {
			M[i][pi[i]] = 1;
			M[pi[i]][i] = 1;
		}
		M[0][0] = 0;
		
		/*MST CREATED, SOURCE AND DESTINATION NEEDED*/
		int src,des;
		printf("\n\nSource & Destination: ");
		scanf("%d %d",&src,&des);
		findpath(src-1,des-1);
	}
	
	system("pause");
	return 0;
}
