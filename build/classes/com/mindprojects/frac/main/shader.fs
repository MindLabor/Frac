#version 120

varying vec2 texCoords;

void main() {
    vec2 z, c;

    c.x = 1.3333 * (gl_TexCoord[0].x - 0.5) * 1 - 0;
    c.y = (gl_TexCoord[0].y - 0.5) * 1 - 0;

    int i;
    z = c;
    for(i=0; i<150; i++) {
        float x = (z.x * z.x - z.y * z.y) + c.x;
        float y = (z.y * z.x + z.x * z.y) + c.y;

        if((x * x + y * y) > 4.0) break;
        z.x = x;
        z.y = y;
    }

    gl_FragColor = (i == iter ? 0.0 : float(i)) / 100.0;
}