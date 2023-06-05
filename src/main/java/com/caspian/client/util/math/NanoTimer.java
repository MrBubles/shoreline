package com.caspian.client.util.math;

import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author linus
 * @since 1.0
 */
public class NanoTimer implements Timer
{
    // The cached time since last reset which indicates the time passed since
    // the last timer reset
    private long time;

    /**
     * Default constructor which will initialize the time to the current time
     * which means {@link #passed(Number)} and {@link #passed(Number, TimeUnit)}
     * will always return <tt>true</tt> initially
     */
    public NanoTimer()
    {
        this.time = System.nanoTime();
    }

    /**
     * Returns <tt>true</tt> if the time since the last reset has exceeded
     * the param time.
     *
     * @param time The param time
     * @return <tt>true</tt> if the time since the last reset has exceeded
     * the param time
     */
    @Override
    public boolean passed(Number time)
    {
        return getElapsedTime() > time.longValue();
    }

    /**
     * Returns <tt>true</tt> if the time since the last reset has exceeded
     * the param time which is in the param units.
     *
     * @param time The param time
     * @param unit The unit of the time
     * @return <tt>true</tt> if the time since the last reset has exceeded
     * the param time
     *
     * @see #passed(Number)
     */
    public boolean passed(Number time, TimeUnit unit)
    {
        return passed(unit.toNanos(time.longValue()));
    }

    /**
     *
     *
     * @return
     */
    @Override
    public long getElapsedTime()
    {
        return System.nanoTime() - this.time;
    }

    /**
     *
     *
     * @return
     */
    public long getElapsedTime(TimeUnit unit)
    {
        return unit.convert(getElapsedTime(), TimeUnit.NANOSECONDS);
    }

    /**
     *
     *
     * @param time
     */
    public void setElapsedTime(long time)
    {
        this.time = System.nanoTime() - time;
    }

    /**
     * Sets the cached time since the last reset to the current time
     */
    @Override
    public void reset()
    {
        time = System.currentTimeMillis();
    }
}