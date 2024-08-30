package com.mojang.minecraft.level.levelgen.synth;

import java.util.Random;

// Classic 0.30 styled noise octaves
public final class PerlinNoise extends Synth {
	private ImprovedNoise[] noiseLevels;
	private int perlin;

	public PerlinNoise(Random var1, int var2) {
		this.perlin = var2;
		this.noiseLevels = new ImprovedNoise[var2];
		
		for(var2 = 0; var2 < 8; ++var2) {
			this.noiseLevels[var2] = new ImprovedNoise(var1);
		}

	}

	public final double getValue(double var1, double var3) {
		double var5 = 0.0D;
		double var7 = 1.0D;

		for(int var9 = 0; var9 < this.perlin; ++var9) {
			var5 += this.noiseLevels[var9].getValue(var1 / var7, var3 / var7) * var7;
			var7 *= 2.0D;
		}

		return var5;
	}
}
