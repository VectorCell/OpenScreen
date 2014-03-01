#include <stdio.h>
#include <stdlib.h>

struct ScreenCmds {
	int count;
	char *cmds[];
};

typedef struct ScreenCmds ScreenCmds;

struct ScreenCmds * getScreenCmds() {
	ScreenCmds *sc = (ScreenCmds *)malloc(sizeof(ScreenCmds));
	sc->count = 4;
	for (int k = 0; k < sc->count; k++)
		sc->cmds[k] = "Jello World";
	return sc;
}

int main(int argc, char *argv[]) {
//	ScreenCmds *screenCmds = getScreenCmds();
//	for (int k = 0; k < screenCmds->count; k++) {
//		printf("%s\n", screenCmds->cmds[k]);
//	}
	ScreenCmds *scs = getScreenCmds();
	for (int k = 0; k < scs->count; k++)
		printf("%d :: %s\n", k, scs->cmds[k]);
//	free(scs);
}
